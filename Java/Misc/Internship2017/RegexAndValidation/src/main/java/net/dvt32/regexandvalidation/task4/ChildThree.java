package net.dvt32.regexandvalidation.task4;

/**
 * A simple child class of AnnotationSorter. 
 * Only used for sorting.
 * 
 * Because Java classes cannot inherit constructors,
 * the child class has its own constructor, which
 * internally calls the superclass constructor.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ChildThree	
	extends AnnotationSorter
{
	public ChildThree(int value) {
		super(value);
	}
}