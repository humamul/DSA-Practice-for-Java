   HashMap<Integer,Integer> hm = new HashMap<>(); /////  LC: 914
        
        int n =arr.length;
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        
        int ans = 0;
        for(Integer i:hm.keySet()){
            ans  = gcd (ans,hm.get(i));            //  i is the key here
        }
        System.out.println(hm+" "+ans);
        if(ans>1) return true;
        return false;
    }
    
    static int gcd(int a,int b){
        if(b==0) return a;
        
        return gcd(b,a%b);
    }
