
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platformcommons.urvi.domain.AssetInfo;
import com.platformcommons.urvi.domain.DTO.AssetDTO;
import com.platformcommons.urvi.domain.MasterFarmer;
import com.platformcommons.urvi.domain.repo.AssetInfoRepo;
import com.platformcommons.urvi.domain.repo.MasterFarmerRepo;
import com.platformcommons.urvi.facade.MasterFarmerFacade;
import com.platformcommons.urvi.messaging.constants.MessagingConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class AssetConsumer {
    @Autowired
    private MasterFarmerFacade masterFarmerFacade;

    @Autowired
    private MasterFarmerRepo masterFarmerRepo;
    @Autowired
    private AssetInfoRepo assetInfoRepo;

    @KafkaListener(topics = MessagingConstant.ASSET_SERVICE_ASSET_DTO_UPDATE)
    public void listenPortfolioFromKafka(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            AssetDTO assetDTO = objectMapper.readValue(message, AssetDTO.class);
            getAssetDTO(assetDTO);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @KafkaListener(topics = MessagingConstant.ASSET_SERVICE_ASSET_LIST_DTO_UPDATE)
    public void listenListAssetDTOFromKafka(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TypeReference<List<AssetDTO>> typeReference = new TypeReference<List<AssetDTO>>() {};
            List<AssetDTO> dtoList = objectMapper.readValue(message, typeReference);
            dtoList.stream().forEach(i-> getAssetDTO(i));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAssetDTO(AssetDTO assetDTO) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            AssetDTO assetDTO = objectMapper.readValue(asset, AssetDTO.class);
            MasterFarmer masterFarmer = new MasterFarmer();

            masterFarmer.setIeid(assetDTO.getOwningEntityId());
            if(assetDTO.getCreatedAt()!=null) {
                LocalDateTime l1 = LocalDateTime.ofInstant(new Date(assetDTO.getCreatedAt()).toInstant(), ZoneId.systemDefault());
                masterFarmer.setAssetCreatedDate(l1.toLocalDate());
            }
//
//            LocalDateTime l2 = LocalDateTime.ofInstant(new Date(assetDTO.getAppLastModifiedAt()).toInstant(), ZoneId.systemDefault());
//            masterFarmer.setAssetUpdatedDateTime(l2.toString());
            Double a =0.0;String landInfo="";
//                    ,b=0.0,c=0.0,d=0.0,e=0.0;
            if(assetDTO.getAssetCategory().getCode().equals("ASSET_CATEGORY.LAND")){
                if(assetDTO.getAssetSubCategory().getCode().equals("ASSET_SUBCATEGORY.LAND_OWNED")){
                    if(assetDTO.getAssetFunctionality().getCode().equals("ASSET_FUNCTIONALITY.RAIN_FED")){
                        a+=assetDTO.getTotalQuantity().getValue();
                        masterFarmer.setLandOwnedRainFed(a);
                        landInfo+="LAND_OWNED_RAIN_FED";
                    }else if (assetDTO.getAssetFunctionality().getCode().equals("ASSET_FUNCTIONALITY.IRRIGATED")){
                        a+=assetDTO.getTotalQuantity().getValue();
                        masterFarmer.setLandOwnedIrrigated(a);
                        landInfo+="LAND_OWNED_IRRIGATED";
                    }
                } if(assetDTO.getAssetSubCategory().getCode().equals("ASSET_SUBCATEGORY.LEASED_IN_LAND")){
                    if(assetDTO.getAssetFunctionality().getCode().equals("ASSET_FUNCTIONALITY.RAIN_FED")){
                        a+=assetDTO.getTotalQuantity().getValue();
                        masterFarmer.setLandLeasedRainFed(a);
                        landInfo+="LEASED_IN_LAND_RAIN_FED";
                    }else if (assetDTO.getAssetFunctionality().getCode().equals("ASSET_FUNCTIONALITY.IRRIGATED")){
                        a+=assetDTO.getTotalQuantity().getValue();
                        masterFarmer.setLandLeasedIrrigated(a);
                        landInfo+="LEASED_IN_LAND_RAIN_FED";
                    }
                }


                if(masterFarmerRepo.existsById(assetDTO.getOwningEntityId())) {
                    MasterFarmer existedMasterFarmer = masterFarmerRepo.findById(assetDTO.getOwningEntityId()).orElseThrow(() -> new RuntimeException("not Found"));
                    if(assetInfoRepo.existsById(assetDTO.getId())){
                        AssetInfo preAsset = assetInfoRepo.getById(assetDTO.getId());
                        if(preAsset.getLandInfo().equals(landInfo)){
                            checks(preAsset.getQuantity(),landInfo,existedMasterFarmer,a);
                            masterFarmerRepo.save(existedMasterFarmer);
                        }else{

                        }
                    }else{

                    }

                    masterFarmerFacade.update(masterFarmer);
                }else {
                    masterFarmer.setLandTotal(a);
                    masterFarmerFacade.save(masterFarmer);
                }

            }


    }

    private void checks(Double preQuantity,String preAsset, MasterFarmer existedMasterFarmer,Double a) {
        if(preAsset.equals("LAND_OWNED_RAIN_FED")){
            if(preQuantity>a || preQuantity<a){
                existedMasterFarmer.setLandOwnedRainFed(existedMasterFarmer
                        .getLandOwnedRainFed() - (preQuantity-a));
                existedMasterFarmer.setLandTotal(existedMasterFarmer
                        .getLandTotal() - (preQuantity-a));
            }
        } else if(preAsset.equals("LAND_OWNED_IRRIGATED")){
            if(preQuantity>a || preQuantity<a){
                existedMasterFarmer.setLandOwnedIrrigated(existedMasterFarmer
                        .getLandOwnedIrrigated() - (preQuantity-a));
                existedMasterFarmer.setLandTotal(existedMasterFarmer
                        .getLandTotal() - (preQuantity-a));
            }
        }else if(preAsset.equals("LEASED_IN_LAND_RAIN_FED")){
            if(preQuantity>a || preQuantity<a){
                existedMasterFarmer.setLandLeasedRainFed(existedMasterFarmer
                        .getLandLeasedRainFed() - (preQuantity-a));
                existedMasterFarmer.setLandTotal(existedMasterFarmer
                        .getLandTotal() - (preQuantity-a));
            }
        }else if(preAsset.equals("LEASED_IN_LAND_IRRIGATED")){
            if(preQuantity>a || preQuantity<a){
                existedMasterFarmer.setLandLeasedIrrigated(existedMasterFarmer
                        .getLandLeasedIrrigated() - (preQuantity-a));
                existedMasterFarmer.setLandTotal(existedMasterFarmer
                        .getLandTotal() - (preQuantity-a));
            }
        }
    }
}
