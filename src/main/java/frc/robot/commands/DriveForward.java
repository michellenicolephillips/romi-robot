package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveForward extends CommandBase {
    private RomiDrivetrain driveTrain;
    private double speed;
    private double time;
    private long startTime;

    public DriveForward (RomiDrivetrain driveTrain, double speed, double time) {
        this.driveTrain = driveTrain;
        this.speed = speed;
        this.time = time;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize () {
        this.startTime = System.currentTimeMillis();
        this.driveTrain.arcadeDrive(0, 0);
    }

    @Override
    public void execute () {
        this.driveTrain.arcadeDrive(this.speed, 0);
    }

    @Override 
    public boolean isFinished () {
        return (System.currentTimeMillis() - this.startTime) >= this.time;
    }

    @Override
    public void end (boolean interrupted) {
        this.driveTrain.arcadeDrive(0, 0);
     }
}
