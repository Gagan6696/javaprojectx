package operations;

public class validations {
 public static boolean isEmpty(String value){
     if (value!=null){
         return value.trim().isEmpty();
     }
     return false;
 }

 public static boolean isNumeric(String value){
     try {
      if(value!=null){
          Integer.parseInt(value.trim());
          return true;
      }   
     } catch (NumberFormatException ex) {
     }
     return false;
    
 
}
}
