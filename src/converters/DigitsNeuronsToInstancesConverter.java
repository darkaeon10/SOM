package converters;
import weka.core.Attribute;
import weka.core.FastVector;
import datasets.DatasetManagerFactory;


public class DigitsNeuronsToInstancesConverter extends NeuronsToInstancesConverter{

    @Override
    protected FastVector createTweetAttributes() {
	
	int numAttributes = this.getNumAttributes();
	
        FastVector attributes = new FastVector(numAttributes);
        for(int i=1;i<=numAttributes;i++){
        	Attribute currSegmentAttribute = new Attribute("Segment"+i);
        	attributes.addElement(currSegmentAttribute);
        }
        
        return attributes;
    }

    @Override
    protected int getNumAttributes() {
	return DatasetManagerFactory.create(DatasetManagerFactory.DIGITS).getNumAttributesWithoutClass();
    }

}
