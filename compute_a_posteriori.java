import java.text.DecimalFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class compute_a_posteriori{
	public static void main(String[] args)throws IOException{
		DecimalFormat df = new DecimalFormat("#.#####");
		FileWriter fw = new FileWriter("result.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		int C = 0,L = 0;
		
		for(int i=0;i<args[0].length();i++){
			if(args[0].charAt(i) == 'C')
				C++;
			else
				L++;
		}
		
		double[] Pd_h_CL = new double[5];
		double[] Ph = new double[5];
		double alpha;
		double sum = 0;
		double[] P_C = new double[5];
		bw.write("Observation Sequence Q: "+args[0]);
		bw.newLine();
		bw.write("Length Q: "+args[0].length());
		bw.newLine();bw.newLine();
		P_C[0] = 1;P_C[1] = 0.75;P_C[2] = 0.5;P_C[3] = 0.25;P_C[4] = 0;
		Ph[0] = 0.1;Ph[1] = 0.2;Ph[2] = 0.4;Ph[3] = 0.2;Ph[4] = 0.1;
		for(int i=0;i<5;i++){
			Pd_h_CL[i] = Math.pow(P_C[i], C) * Math.pow((1-P_C[i]), L) * (Ph[i]);
			sum += Pd_h_CL[i];
		}
		alpha = 1/sum;
		for(int i=0;i<5;i++){
			Pd_h_CL[i] *= alpha;
			bw.write("P(h"+(i+1)+" |Q) = "+df.format(Pd_h_CL[i]));
			bw.newLine();
		}
		
		sum = 0;
		for(int i=0;i<5;i++){
			sum += (P_C[i] * Pd_h_CL[i]);
		}
		bw.newLine();
		bw.write("Probability that the next candy we pick will be C, given Q: "+df.format(sum));
		bw.newLine();
		bw.newLine();
		bw.write("Probability that the next candy we pick will be L, given Q: "+df.format(1 - sum));
		bw.newLine();
		bw.close();
	}
}