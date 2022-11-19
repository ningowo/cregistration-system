package teams.ksv.kwrs.statemachine;

public abstract class CourseStateMachine {

    private State state;

    public CourseStateMachine(State initState) {
        this.state = initState;
    }

    public abstract void submit();

    public abstract void approve();

    public abstract void decline();

}
