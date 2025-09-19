class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record=new Stack<>();
        for(String op : operations){
            switch (op){
                case "+":
                    int last=record.pop();
                    int secondlast=record.peek();
                    record.push(last);
                    record.push(last + secondlast);
                    break;
                case "D":
                    record.push(2*record.peek());
                    break;
                case "C":
                    record.pop();
                    break;
                default:
                    record.push(Integer.parseInt(op));
            }
        }
        int sum=0;
        for(int score:record){
            sum=sum+score;
        } 
        return sum;        
    }
}