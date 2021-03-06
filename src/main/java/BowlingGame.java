public class BowlingGame {

  public int getBowlingScore(String bowlingCode) {
    int sumscore=0;
		int length=bowlingCode.split("|").length;
		int count=0;
		char[] bowlingscore=bowlingCode.toCharArray();
		int[] score=new int[length-10];
		for(int i=0;i<length;i++){//转为每个球打的分数
			char s=bowlingscore[i];
			switch(s){
			case 'X':
				score[count]=10;
				count++;
				break;
			case '/':
				score[count]=10-score[count-1];
				count++;
				break;
			case '-':
				score[count]=0;
				count++;
				break;
			case '|':
				break;
			default:
				score[count]=Integer.parseInt(bowlingCode.split("|")[i]);
				count++;
				break;
			}
		}
		int num=0;
		for(int i=0;i<10;i++){
			switch(score[num]){//计算总分
			case 10:
				sumscore+=10;
				sumscore+=score[num+1]+score[num+2];
				num++;
				break;
			default:
				if(score[num]+score[num+1]==10){
					sumscore+=10+score[num+2];
					num+=2;
				}else{
					sumscore+=score[num]+score[num+1];
					num+=2;
				}
			}
		}
		System.out.println(sumscore);
	    return sumscore;
    }
}
