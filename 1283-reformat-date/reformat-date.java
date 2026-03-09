class Solution {
    public String reformatDate(String date) {
        Map<String, String> monthMap= new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String []parted= date.split(" ");

        String day=parted[0].replaceAll("[a-z]","");
        if(day.length() == 1){
            day="0"+day;
        }

        String month=monthMap.get(parted[1]);

        String year=parted[2];

        return year + "-" + month + "-" + day;
    }
}