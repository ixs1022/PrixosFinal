//COMMAND PATTERN
public class FlipCommand implements Command {
	
		//attributes
		EditingOptions option;
		
		//Constructor
		public FlipCommand(EditingOptions newOption){
			this.option = newOption;
		}
		
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
