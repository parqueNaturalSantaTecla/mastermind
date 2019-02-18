package mastermind.views;
import mastermind.controllers.Controller;
import mastermind.controllers.Logic;

public class Mastermind {
	
	private Logic logic;
	
	private ConsoleView consoleView;
	
	public Mastermind() {
		this.logic = new Logic();
		this.consoleView = new ConsoleView();
	}
	
	public void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				this.consoleView.interact(controller);
			}
		} while (controller != null); 
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}
	
}

/** 
 * @startuml
enum Color [[java:mastermind.models.Color]] {
	RED
	BLUE
	YELLOW
	GREEN
	ORANGE
	PURPLE
	+{static}Color getInstance(int code)
	+{static}int length()
	+{static}void main(String[] args)
}
class Game [[java:mastermind.models.Game]] {
	-{static}int MAX_LONG
	-int turn
	+Game()
	+void clear()
	+int getWidth()
	+void proposeCombination(ProposedCombination proposedCombination)
	+int[][][] getCodes()
	+boolean isGameOver()
	+int getTurn()
}
class SecretCombination [[java:mastermind.models.SecretCombination]] {
}
Game --> "1" SecretCombination : secretCombination
class ProposedCombination [[java:mastermind.models.ProposedCombination]] {
}
Game --> "*" ProposedCombination : proposedCombinations
class Result [[java:mastermind.models.Result]] {
}
Game --> "*" Result : results
class StartController [[java:mastermind.controllers.StartController]] {
	+StartController(Game game, State state)
	+void start()
	+void accept(ControllerVisitor controllerVisitor)
}
class Controller [[java:mastermind.controllers.Controller]] {
}
Controller <|-- StartController
class ProposedCombinationView [[java:mastermind.views.ProposedCombinationView]] {
	-{static}String TITTLE
	+{static}int ERROR_CODE
	+void write(int[] codes)
	+int[] read()
}
class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
}
WithConsoleView <|-- ProposedCombinationView
class Logic [[java:mastermind.controllers.Logic]] {
	+Logic()
	+Controller getController()
}
class State [[java:mastermind.controllers.State]] {
}
Logic --> "1" State : state
class Game [[java:mastermind.models.Game]] {
}
Logic --> "1" Game : game
class StartController [[java:mastermind.controllers.StartController]] {
}
Logic --> "1" StartController : startController
class ProposalController [[java:mastermind.controllers.ProposalController]] {
}
Logic --> "1" ProposalController : proposalController
class ResumeController [[java:mastermind.controllers.ResumeController]] {
}
Logic --> "1" ResumeController : resumeController
class SecretCombination [[java:mastermind.models.SecretCombination]] {
	+SecretCombination()
	+Result getResult(ProposedCombination proposedCombination)
}
class Combination [[java:mastermind.models.Combination]] {
}
Combination <|-- SecretCombination
enum Error [[java:mastermind.models.Error]] {
	DUPLICATED
	WRONG_CHARACTERS
	WRONG_LENGTH
}
class Console [[java:mastermind.utils.Console]] {
	-BufferedReader bufferedReader
	+String readString(String title)
	+int readInt(String title)
	+char readChar(String title)
	+void writeln()
	+void write(String string)
	+void writeln(String string)
	+void write(char character)
	+void writeln(int integer)
	-void writeError(String formato)
}
class ResumeView [[java:mastermind.views.ResumeView]] {
	+void interact(ResumeController resumeController)
}
class ConsoleView [[java:mastermind.views.ConsoleView]] {
	+ConsoleView()
	+void interact(Controller controller)
	+void visit(StartController startController)
	+void visit(ProposalController proposalController)
	+void visit(ResumeController continueController)
}
class StartView [[java:mastermind.views.StartView]] {
}
ConsoleView --> "1" StartView : startView
class ProposalView [[java:mastermind.views.ProposalView]] {
}
ConsoleView --> "1" ProposalView : proposalView
class ResumeView [[java:mastermind.views.ResumeView]] {
}
ConsoleView --> "1" ResumeView : continueView
interface ControllerVisitor [[java:mastermind.controllers.ControllerVisitor]] {
}
ControllerVisitor <|.. ConsoleView
class ResultView [[java:mastermind.views.ResultView]] {
	-{static}String MESSAGES
	+void writeln(int[] results)
}
class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
}
WithConsoleView <|-- ResultView
class ResumeController [[java:mastermind.controllers.ResumeController]] {
	+ResumeController(Game game, State state)
	+void resume(boolean resume)
	+void accept(ControllerVisitor controllerVisitor)
}
class Controller [[java:mastermind.controllers.Controller]] {
}
Controller <|-- ResumeController
class Result [[java:mastermind.models.Result]] {
	-int blacks
	-int whites
	+Result(int blacks, int whites)
	+boolean isWinner()
	+int[] getCodes()
	+{static}void main(String[] args)
}
class ErrorView [[java:mastermind.views.ErrorView]] {
	-{static}Map<Integer,String> MESSAGES
	+{static}int NO_ERROR
	-{static}int DUPLICATED
	-{static}int WRONG_CHARACTERS
	-{static}int WRONG_LENGTH
	+void write(int error)
}
class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
}
WithConsoleView <|-- ErrorView
enum StateValue [[java:mastermind.controllers.StateValue]] {
	INITIAL
	IN_GAME
	FINAL
	EXIT
	-StateValue()
	+void set(Controller controller)
	+Controller getController()
}
class Controller [[java:mastermind.controllers.Controller]] {
}
StateValue --> "1" Controller : controller
class SecretCombinationView [[java:mastermind.views.SecretCombinationView]] {
	-{static}String HIDDEN
	+SecretCombinationView()
	+void writeln(int length)
}
class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
}
WithConsoleView <|-- SecretCombinationView
class YesNoDialog [[java:mastermind.utils.YesNoDialog]] {
	-{static}char AFIRMATIVE
	-{static}char NEGATIVE
	-{static}String QUESTION
	-{static}String MESSAGE
	+YesNoDialog()
	+boolean read(String title)
	-{static}boolean isAfirmative(char answer)
	-{static}boolean isNegative(char answer)
}
class Console [[java:mastermind.utils.Console]] {
}
YesNoDialog --> "1" Console : console
interface ControllerVisitor [[java:mastermind.controllers.ControllerVisitor]] {
	void visit(StartController startController)
	void visit(ProposalController proposalController)
	void visit(ResumeController continueController)
}
class ClosedInterval [[java:mastermind.utils.ClosedInterval]] {
	-int min
	-int max
	+ClosedInterval(int min, int max)
	+boolean includes(int value)
}
class Mastermind [[java:mastermind.views.Mastermind]] {
	+Mastermind()
	+void play()
	+{static}void main(String[] args)
}
class Logic [[java:mastermind.controllers.Logic]] {
}
Mastermind --> "1" Logic : logic
class ConsoleView [[java:mastermind.views.ConsoleView]] {
}
Mastermind --> "1" ConsoleView : consoleView
enum ColorView [[java:mastermind.views.ColorView]] {
	RED
	BLUE
	YELLOW
	GREEN
	ORANGE
	PURPLE
	initial
	-ColorView(char initial)
	+void write()
	+{static}String allInitials()
	+{static}ColorView getInstance(int code)
	+{static}ColorView getInstance(char character)
	+{static}Error isValid(char character)
}
abstract class Controller [[java:mastermind.controllers.Controller]] {
	+Controller(Game game, State state)
	+int getWidth()
	+{abstract}void accept(ControllerVisitor controllerVisitor)
}
class Game [[java:mastermind.models.Game]] {
}
Controller --> "1" Game : game
class State [[java:mastermind.controllers.State]] {
}
Controller --> "1" State : state
class ProposalController [[java:mastermind.controllers.ProposalController]] {
	+ProposalController(Game game, State state)
	+int proposeCombination(int[] codes)
	+int[][][] getAllCodes()
	+int getTurn()
	+void accept(ControllerVisitor controllerVisitor)
}
class Controller [[java:mastermind.controllers.Controller]] {
}
Controller <|-- ProposalController
abstract class Combination [[java:mastermind.models.Combination]] {
	-{static}int WIDTH
	#Combination()
	+{static}int getWidth()
}
class Color [[java:mastermind.models.Color]] {
}
Combination --> "*" Color : colors
class StartView [[java:mastermind.views.StartView]] {
	-{static}String TITTLE
	+void interact(StartController startController)
}
class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
}
WithConsoleView <|-- StartView
class ProposalView [[java:mastermind.views.ProposalView]] {
	-{static}String MESSAGES
	+void interact(ProposalController proposalController)
}
class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
}
WithConsoleView <|-- ProposalView
class ProposedCombination [[java:mastermind.models.ProposedCombination]] {
	+{static}Error isValid(int[] codes)
	+{static}ProposedCombination getInstance(int[] codes)
	+int[] getCodes()
	+boolean contains(Color color, int position)
	+boolean contains(Color color)
}
class Combination [[java:mastermind.models.Combination]] {
}
Combination <|-- ProposedCombination
abstract class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
	+WithConsoleView()
}
class Console [[java:mastermind.utils.Console]] {
}
WithConsoleView --> "1" Console : console
class State [[java:mastermind.controllers.State]] {
	+State()
	+void next()
	+void reset()
	+StateValue getValueState()
}
class StateValue [[java:mastermind.controllers.StateValue]] {
}
State --> "1" StateValue : stateValue

@enduml
*/