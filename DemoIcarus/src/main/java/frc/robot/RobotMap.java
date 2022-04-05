package frc.robot;

public class RobotMap {
    // speed modifiers
    public static double speedMod = 0.5;
    public static double slowMod = 0.4;
    public static double fastMod = 0.7;
    public static double conveyorMod = 1;
    public static double shooter = 0.6;
    public static double wench = 0.4;
    // debug toggles
    public static final boolean debug = false;
    public static final boolean driveDebug = false;
    // drive train deadzone
    public static double deadzone = 0.15;

    /// Motor Ports (CAN BUS) ///
    // drive train
    public static final int leftMotorLeader = 3;
    public static final int leftMotorFollower = 4;
    public static final int rightMotorLeader = 1;
    public static final int rightMotorFollower = 2;
    // special functions
    public static final int conveyorMotor = 5;
    public static final int shooterMotorTop = 6;
    public static final int shooterMotorBottom = 7;
    public static final int wenchMotor = 9;
}
