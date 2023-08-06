package Lesson_03;

import java.io.*;

class DataParser {
    private String inData;
    private String[] dataParts;
    BufferedReader in;
    public DataParser() {
        this.inData = null;
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    int inputData(String title) {

        System.out.print(title);
        try {
            inData= in.readLine();
            if(inData.length() == 0){
                return -1;
            }
            dataParts = inData.split(" ");
            if(dataParts.length != 6){
                return -2;
            }

            for (String part : dataParts) {
                System.out.println(part);
            }

            if(!this.checkFio()){
                return -3;
            }

            if(!this.checkDate()){
                return -4;
            }

            if(!this.checkPhone()){
                return -5;
            }

            if (!this.checkGender()){
                return -6;
            }

        }catch (IOException e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        }
        return 0;
    }

    public void saveToFile(){
        File dataFile = new File(this.dataParts[0]);
        try (FileWriter writer = new FileWriter(dataFile, true)) {
            for (String s : this.dataParts) {
                writer.append(String.format("<%s>", s));
            }
            writer.append("\n");
            writer.flush();
//            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private boolean checkFio() {
        for (int i = 0; i < 3; i++){
            if(!this.dataParts[i].matches("^[a-zA-Zа-яА-я]*$")){
                return false;
            }
        }
        return true;
    }
    private boolean checkDate() {
        String regex = "^([0-2][0-9]||3[0-1])\\.(0[0-9]||1[0-2])\\.([0-9][0-9])?[0-9][0-9]$";
        return this.dataParts[3].matches(regex);
    }
    private boolean checkPhone() {
        try {
            Long.parseLong(this.dataParts[4]);
            return true;
        }catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean checkGender() {
        String regex = "[fm]";
        return this.dataParts[5].matches(regex);
    }
}