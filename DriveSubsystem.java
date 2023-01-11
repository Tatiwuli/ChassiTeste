

package frc.robot.subsystems;



import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    private Spark m_left1;
    private Spark m_left2;
    private Spark m_right1;
    private Spark m_right2;

    
    private MotorControllerGroup m_leftMotors;
    private MotorControllerGroup m_rightMotors;
    private DifferentialDrive m_drive;

   

    public DriveSubsystem() {
        m_left1 = new Spark(Constants.PWMPorts.kLeft1Port);
        m_left2 = new Spark(Constants.PWMPorts.kLeft2Port);
        m_right1 = new Spark(Constants.PWMPorts.kRight1Port);
        m_right2 = new Spark(Constants.PWMPorts.kRight2Port);

 

        m_leftMotors = new MotorControllerGroup(m_left1, m_left2);
        m_rightMotors = new MotorControllerGroup(m_right1, m_right2);

        m_leftMotors.setInverted(true);
        m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

      
    }

    public void setLeftMotors(double speed) {
        m_leftMotors.set(speed);
    }

    public void setRightMotors(double speed) {
        m_rightMotors.set(speed);
    }

    public void tankDrive(double left, double right) {
        m_drive.tankDrive(left, right);
    }
}

  