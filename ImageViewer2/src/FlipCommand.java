//COMMAND PATTERN
/**
 * FlipCommand implements Command
 * Class responsible for functionality that flips image horizontally
 * @author Ivan Kovacevic
 *
 */
public class FlipCommand implements Command {
	
		//attributes
		EditingOptions option;
		
		/**
		 * Constructor for FlipCommand
		 * @param newOption EditingOptions
		 */
		public FlipCommand(EditingOptions newOption){
			this.option = newOption;
		}
		
		/**
		 * Following methods are implemented from Command interface
		 * Only execute() is overriden for use for this command
		 */
		@Override
		public void execute() {
			option.flip();
			
		}
		@Override
		public void execute(int w, int h) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void execute(double deg) {
			
		}

}
