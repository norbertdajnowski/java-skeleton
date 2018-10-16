package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		
		int [][] finalPortfolio = new int [16][2];
		int finalOutput = 0;
		
		for (int x = 0; x <= 1 ; x++) {
			
			int conversionIndex = 32768;
			
			for (int i = 15; i >= 0; i--) {
			
				
				if ((portfolios[x] - conversionIndex) >= 0) {

					portfolios[x] = portfolios[x] - conversionIndex;
					finalPortfolio[i][x] = 1;
					
				}

				conversionIndex = conversionIndex / 2;
				
			}
		}
		
		for (int i = 0; i <= 15; i++) {
			
			if ((finalPortfolio[i][0] == finalPortfolio[i][1]) && ((finalPortfolio[i][0] == 1) | (finalPortfolio[i][0] == 0))){
				
				finalPortfolio[i][0] = 0;
				
			}
			else {
				
				finalPortfolio[i][0] = 1;
				
			}
			
		}

		int conversionIndex = 32768;
				
		for (int i = 15; i >= 0; i--) {
			
			if (finalPortfolio[i][0] == 1) {
				finalOutput = finalOutput + conversionIndex;
			}
			
		conversionIndex = conversionIndex / 2;
			
		}
		
		return finalOutput;
	}

}
