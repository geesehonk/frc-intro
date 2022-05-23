package frc.robot.subsystems.intake;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intake extends SubsystemBase {
    public final CANSparkMax intakeMotor;
    public final RelativeEncoder intakeEncoder;
    public SparkMaxPIDController intakeController;

public intake (int port) {
    intakeMotor = new CANSparkMax(Motor.kPort, CANSparkMax.MotorType.kBrushless);
    this.intakeEncoder = this.intakeMotor.getEncoder();
    this.intakeController = this.intakeMotor.getPIDController();
    intakeMotor.setIdleMode(IdleMode.kBrake);
    
    this.intakeController.setP(Constants.Intake.kP);
    this.intakeController.setI(Constants.Intake.kI);
    this.intakeController.setD(Constants.Intake.kD);
    this.intakeController.setFF(Constants.Intake.kFF);
    }

public void setIntakePower(double power) {
    this.rotationPower = power;
}

public void intake()  {
    this.intakeMotor.setPower(this.rotationPower);
    this.intakeMotor.setPower(-this.rotationPower);
}

public void stop()  {
    this.setPower(0);
}