// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj2.command.RunCommand;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final Joystick m_stick1Left = new Joystick(Constants.kStick1Port);
  private final Joystick m_stick1Right = new Joystick(Constants.kStick1Port);

  public RobotContainer() {
      m_stick1Right.setYChannel(5);
      m_stick1Right.setThrottleChannel(2);
    configureBindings();
  }

  
   
  private void configureBindings() {
    m_driveSubsystem.setDefaultCommand(new RunCommand(
      () -> m_driveSubsystem.tankDrive(m_stick1Left.getY(), m_stick1Right.getY()),
      m_driveSubsystem));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public boolean getAutonomousCommand() {
    // An example command will be run in autonomous
    return false;
  }
}
