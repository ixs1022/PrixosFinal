import javax.swing.ImageIcon;

public class ImageClone implements ImagePrototype{
	// attributes
	private ImageIcon ic;
	
	/**
	 * Constructor
	 */
	public ImageClone(ImageIcon ic){
		this.ic = ic;
		//ic = new ImageIcon();
	}
	
	/**
	 * Method to make copy of image for editing
	 */
	@Override
	public ImageIcon makeCopy() {
		
		try {
			ic = (ImageIcon) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			System.out.println("Cannot clone image");
		}
		return ic;
	}

}
