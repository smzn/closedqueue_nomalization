package convolution;

public class Convolution_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] alpha = {0.4, 0.2, 0.4}, mu = {1,2,2};
		int N = 5, K = 3;
		
		Convolution_lib clib = new Convolution_lib(alpha, mu);
		
		//kは拠点番号だが、プログラム中の配列番号に合わせるため-1してある。
		double g = clib.calcConvolution(N, K-1);
		double gg = clib.calcConvolution(N-1, K-1);
		clib.setG(g);
		clib.setGg(gg); 
		System.out.println("G("+N+","+K+")="+g);
		
		//Throughput計算
		for(int i = 0; i < K; i++){
			System.out.println("Throughput("+i+")="+alpha[i]*clib.getGg()/clib.getG());
		}
		
		//稼働率計算
		for(int i = 0; i < K; i++){
			System.out.println("Availability("+i+")="+alpha[i]/mu[i]*clib.getGg()/clib.getG());
		}
		
	}

}
