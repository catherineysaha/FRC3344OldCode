package frc.robot.commands;
import frc.robot.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.Constants;

public class RightStrafe extends CommandBase{
    private double strafeSpeed;
    public RightStrafe(DriveTrain driveTrain){
        //addRequirements(driveTrain);
    }
    public void initialize(){
       strafeSpeed = SmartDashboard.getNumber("Strafe Speed", Constants.strafeSpeed);

    }
    public void execute(){
        strafeSpeed = SmartDashboard.getNumber("Strafe Speed", Constants.strafeSpeed);
        RobotContainer.mecanum.mecanumDrive(
            strafeSpeed*-1/100, 
            strafeSpeed*-1/100);
        isFinished();
    }
    public boolean isFinished(){
        return RobotContainer.stickMain.getRightTrigger() ==0;
    }
    public boolean isInterrupted(){
        return RobotContainer.stickMain.getLeftJoyY() !=0 || RobotContainer.stickMain.getRightJoyY() !=0;
    }
    protected void end(){

    }
    protected void interrupted(){
        end();
    }
}