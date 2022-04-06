// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveTrainCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrainSubsystem driveTrainSubsystem;
  // create an override variable
  private boolean overrideMod;
  private double speedModifier;
  private boolean fastCheck;
  private boolean slowCheck;
  // import controllers
  private static XboxController driver = RobotContainer.driverController;
  private static XboxController override = RobotContainer.overrideController;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveTrainCommand(DriveTrainSubsystem subsystem) {
    driveTrainSubsystem = subsystem;
    System.out.println("command enabled");
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // get controller inputs
    overrideMod = override.getAButton();
    double leftDrive = driver.getLeftY();
    double rightDrive = override.getRightY();
    fastCheck = override.getRightBumper();
    slowCheck = override.getLeftBumper();
    // determine speed

    if (Math.abs(leftDrive) < RobotMap.deadzone) {
      leftDrive = 0;
    }
    if (Math.abs(rightDrive) < RobotMap.deadzone) {
      rightDrive = 0;
    }
    if (fastCheck == true && slowCheck == true) {
      speedModifier = RobotMap.speedMod;
    } else if (fastCheck == true) {
      speedModifier = RobotMap.fastMod;
    } else if (slowCheck == true) {
      speedModifier = RobotMap.slowMod;
    } else {
      speedModifier = RobotMap.speedMod;
    }

    if (overrideMod == true) {
      RobotContainer.m_exampleSubsystem.setMotors(0, 0);
    } else {
      RobotContainer.m_exampleSubsystem.setMotors(
          -leftDrive * speedModifier,
          rightDrive * speedModifier);
    }
    System.out.println(leftDrive + " " + rightDrive + " " + overrideMod);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
