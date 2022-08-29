package filejava.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.*;
import java.util.*;

public class doLogin {

    private final static String TOKEN = tokenGenerator();

    private static String tokenGenerator(){
        File file = new File("randomString.txt");
        String str = "";
        try {
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            str = br.readLine();
        } catch (IOException e){
            System.out.println("ERREUR : Fichier introuvable !");
            e.printStackTrace();
        }
        return str;
    }

    public static Map<String, String> introspect(String token){
        Claims claims = Jwts.parser().setSigningKey(TOKEN).parseClaimsJws(token).getBody();
        boolean check = verifyExpirationDate(token);
        if(check == true){
            return null;
        }
        Map<String, String> map = new HashMap<>();
        map.put("name", claims.get("name", String.class));
        map.put("uuid", claims.get("uuid", String.class));
        return map;
    }

    public static boolean verifyExpirationDate(String token) {
         Claims claims = Jwts.parser().setSigningKey(TOKEN).parseClaimsJws(token).getBody();
         Date expirationDate = claims.getExpiration();
         Date currentDate = new Date();
         if(currentDate.after(expirationDate)) {
             System.out.println("La date d'expiration du token a expiré !");
             return true;
         }
         return false;
    }

    public static String createToken(String name, String uuid){
        Map<String, String> content = new HashMap<>();
        content.put("name", name);
        content.put("uuid", uuid);

        return Jwts.builder().setClaims(content)
                .setId(UUID.randomUUID().toString())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .signWith(SignatureAlgorithm.HS256, TOKEN)
                .compact();
    }
}