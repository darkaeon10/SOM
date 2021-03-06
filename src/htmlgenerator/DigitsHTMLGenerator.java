package htmlgenerator;
import java.util.LinkedList;

public class DigitsHTMLGenerator implements HTMLGenerator {

    public String generateHTML(int[] clusters,
	    LinkedList<LinkedList<String>> labeledSOM) {

	StringBuilder sb = new StringBuilder();
	sb.append("<html> \n <title></title> <body> <table border='1'>");
	sb.append(createColoredString(clusters, labeledSOM));
	sb.append("\n </table></body> </html>");

	return sb.toString();
    }

    private static String createColoredString(int[] clusters,
	    LinkedList<LinkedList<String>> labeledSOM) {

	int numRows = labeledSOM.size();
	int numCols = labeledSOM.get(0).size();
	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < numRows; i++) {

	    LinkedList<String> currRow = labeledSOM.get(i);

	    sb.append("<tr>");
	    
	    for (int j = 0; j < numCols; j++) {

		String category = currRow.get(j);

		int currNeuronIndex = i * numCols + j;
		int clusterNum = clusters[currNeuronIndex];

		sb.append("<td style='color:");

		switch (clusterNum) {
		case 0:
		    sb.append("#E74C3C");
		    break;
		case 1:
		    sb.append("#D35400");
		    break;
		case 2:
		    sb.append("#F1C40F");
		    break;
		case 3:
		    sb.append("#1ABC9C");
		    break;
		case 4:
		    sb.append("#2ECC71");
		    break;
		case 5:
		    sb.append("#3498DB");
		    break;
		case 6:
		    sb.append("#9B59B6");
		    break;
		case 7:
		    sb.append("#2C3E50");
		    break;
		case 8:
		    sb.append("#7F8C8D");
		    break;
		case 9:
		    sb.append("#ECF0F1");
		    break;
		}

		sb.append("'>");
		sb.append(category);
		sb.append("</td> ");
	    }

	    sb.append("</tr>");
	}
	return sb.toString();
    }

}
