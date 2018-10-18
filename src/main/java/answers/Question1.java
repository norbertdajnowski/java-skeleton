package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		
		int [][] finalPortfolio = new int [portfolios.length][16];
		
		List<Integer> binaryList = new ArrayList();
		
		List<Integer> finalList = new ArrayList();
		
		
		// Take all porfolio's and convert to binary
		
		for (int x = 0; x <= portfolios.length - 1 ; x++) {
			
			int conversionIndex = 32768;
			
			for (int i = 15; i >= 0; i--) {
			
				//loop through every bit (16 bits), check if taking away the bit size leaves a number larger than 0
				
				if ((portfolios[x] - conversionIndex) >= 0) {

					portfolios[x] = portfolios[x] - conversionIndex;
					finalPortfolio[x][i] = 1;
					
				}

				conversionIndex = conversionIndex / 2;
				
			}
		}
		
		// Merge every possible portfolio with another
		
		int indexMerge = 0;
		
		for (int z = 0; z <= portfolios.length - 1; z ++) {
		
		for (int y = portfolios.length - 1; y >= 0; y--) {			
		
		for (int i = 0; i <= 15 ; i++) {
			
			//create a sublist of 16 bit binaries, adding them to the end of a finallist
			
			if ((finalPortfolio[z][i] == finalPortfolio[y][i]) && ((finalPortfolio[z][i] == 1) | (finalPortfolio[y][i] == 0))){
				
				binaryList.add(0);
				
			}
			else {
				
				binaryList.add(1);
				
			}
			
			
		}
		    
		    finalList.addAll(binaryList);
			indexMerge = indexMerge + 1;
			binaryList.clear();
		
		}
		}
		
		// Modify the finalList to return every value as 16 bit binary and display the value in final output
		
		int [] finalOutput = new int [indexMerge];
		
		for (int x = 0; x <= indexMerge - 1; x ++) {
			
			int conversionIndex = 1;
			
		for (int i = 15; i >= 0; i--) {
			
			try {
				if (finalList.get(0) == 1) {
					
					finalOutput[x] = finalOutput[x] + conversionIndex;
					
				}
			}
			catch (Exception e) {
				
			}
			
		finalList.remove(0);	
		conversionIndex = conversionIndex * 2;
			
		}
		
			System.out.println(finalOutput[x]+ "  ");
		
		}
		
		//Sort the final output and display the largest one
		
		Arrays.sort(finalOutput);
		
		
		return finalOutput[indexMerge - 1];
	}
	
	

}
