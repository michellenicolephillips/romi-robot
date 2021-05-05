package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveDistance extends CommandBase{
    private RomiDrivetrain driveTrain;
    private double speed;
    private double distanceInches;

    public DriveDistance(RomiDrivetrain driveTrain, double speed, double distanceInches) {
        this.driveTrain = driveTrain;
        this.speed = speed;
        this.distanceInches = distanceInches;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
    this.driveTrain.resetEncoders();
     this.driveTrain.arcadeDrive(0, 0);   
    }

    @Override
    public void execute() {
        this.driveTrain.arcadeDrive(this.speed, 0);
    }

    @Override
    public boolean isFinished() {
        return (this.driveTrain.getLeftDistanceInch() + this.driveTrain.getRightDistanceInch())/2 >= this.distanceInches;
    }

    @Override
    public void end(boolean interrupted) {
        this.driveTrain.arcadeDrive(0, 0);
    }
}