package ma.enset.service;

public class SecurityContext {
    private static String username="";
    private static String password="";
    private static String[] roles={};

    public static void authenticate(String u, String p,String[] r) {
        if(u.equals("admin") && p.equals("admin")){
            username = u;
            password = p;
            roles=r;
        }else{
            throw new RuntimeException("Access denied");
        }
    }

    public static boolean hasRole(String r) {
        for(String rr:roles){
            if(r.equals(rr)){
                return true;
            }
        }
        return false;
    }
}
