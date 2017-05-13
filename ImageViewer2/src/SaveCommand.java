/**
 * SaveCommand, when called, saves the new edited image
 * First time it is called, user can rename image (and add to album of choice)
 * After that, image is saved normally
 * 
 * @author isabella
 *
 */
public class SaveCommand implements Command {

	//attributes
		EditingOptions option;
		
		/**
		 * Constructor for SaveCommand
		 * @param newOption EditingOptions
		 */
		public SaveCommand(EditingOptions newOption){
			this.option = newOption;
		}
		
		/**
		 * Implemented execute methods from Command interface
		 * Only execute() are used for Save
		 */
		@Override
		public void execute() {
			option.saveImage();
		}
		@Override
		public void execute(int w, int h) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void execute(double deg) {
				
		}

}
