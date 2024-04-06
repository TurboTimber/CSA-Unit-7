import java.util.ArrayList;

public class EQ {

    private int out;
    private String eq;
    private int[] domain;


    public EQ (String eq){
        this.eq = eq;
       // this.domain = domain;
    }

    public double solver (){
        int x = 5;
        double runTotal = 0.00;
        if(eq.contains(")")){
            //determans if there is a set of perenthaces in the equation if there is then it takes the most interer set and creats a sub string of it.
            int closed = eq.indexOf(")");
            int i;
            for (i = closed; eq.charAt(i) != '('; i--);
            String inter = eq.substring(i,closed+1);
            System.out.println(inter);
            // deals with an exponent if there is one
            if(inter.contains("^")){
                if(inter.charAt(inter.indexOf("^")-1) == 'x'){
                    //Vareable to a power
                    double xpowTotal = Math.pow(x,numUp(inter,inter.indexOf("^")+1));
                    if(isNum(inter.charAt(inter.indexOf("x")-1))){
                        runTotal = xpowTotal * numDown(inter,inter.indexOf("x")-1);
                    }else{
                        runTotal = xpowTotal;
                    }
                }else {
                    //int to a power
                    runTotal = Math.pow(numDown(inter,inter.indexOf("^")-1),numUp(inter,inter.indexOf("^")+1));
                }


            }
        }

        return runTotal;
    }

    public double multDev (String subject){
        int x = 3;
        int total = 0;
        ArrayList<String> subpart = new ArrayList<>();
        String temp = "";
        for(int i = 0; i<subject.length(); i++){

            if(isOp(subject.charAt(i))){
                subpart.add(temp);
                subpart.add("" + subject.charAt(i));
                temp = "";
            }else{
                temp += subject.substring(i,i+1);
            }
        }
        subpart.add(temp);
        for(int i = 0; i <subpart.size();i++){
            if(subpart.get(i).contains("*")||subpart.get(i).contains("/")){
                if(subpart.get(i-1).contains("x")){
                    git remote add origin https://github.com/TurboTimber/CSA-Unit-7.git                    total = numDown(subpart.get(i-1), subpart.get(i-1).length()-1)*x;
                    if(subpart.get(i+1).contains("x")){
                        int inttemp = numDown(subpart.get(i+1), subpart.get(i+1).length())*x;
                        System.out.println(total*inttemp);

                    }
                }
            }
        }
        System.out.println(subpart);
        return -1;
    }




    private boolean isNum (char test){
        String nums = ".0123456789";
        String s = "" + test;
        if(nums.contains(s)){
            return true;
        }else{
            return false;
        }
    }
    private int numUp (String input, int start){
        int i = start;
        while (isNum(input.charAt(i)) && i<input.length()){
            i++;
        }
        return  Integer.parseInt(input.substring(start,i));
    }
    private int numDown (String input, int start){
        int i = start-1;
        while (isNum(input.charAt(i)) && i>0){
            i--;
        }
        return  Integer.parseInt(input.substring(i,start));
    }
    public boolean isOp (char test){
        String ops = "+-*/";
        String s = "" + test;
        if(ops.contains(s)){
            return true;
        }else{
            return false;
        }
    }
    private boolean isAdd (char test){
        if(test == '+'){
            return true;
        }else{
            return false;
        }
    }
    private boolean isSub (char test){
        if(test == '-'){
            return true;
        }else{
            return false;
        }
    }
    private boolean isMult (char test){
        if(test == '*'){
            return true;
        }else{
            return false;
        }
    }
    private boolean isDev (char test){
        if(test == '/'){
            return true;
        }else{
            return false;
        }
    }

}
