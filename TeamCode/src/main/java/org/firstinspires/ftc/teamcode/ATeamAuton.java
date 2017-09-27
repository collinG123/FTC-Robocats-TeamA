/*
Made by Shan B., Collin G., Michael K.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name= "Auton Alpha 1.0", group= "Autonomous")
public abstract class ATeamAuton extends LinearOpMode {



    public static final double COUNTS_PER_MOTOR_REV = 1220;
    public static final double DRIVE_GEAR_REDUCTION = 1.0;
    public static final double WHEEL_DIAMETER_INCHES = 4.0;
    public static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);
    public static final double DRIVE_SPEED = 0.5;
    public static final double TURN_SPEED = 0.5;

    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor leftDrive1 = null;
    public DcMotor leftDrive2 = null;
    public DcMotor rightDrive1 = null;
    public DcMotor rightDrive2 = null;

    @Override
    public void runOpMode() {

        leftDrive1  = hardwareMap.get(DcMotor.class, "leftDrive1");
        rightDrive1 = hardwareMap.get(DcMotor.class, "rightDrive1");
        leftDrive2  = hardwareMap.get(DcMotor.class, "leftDrive2");
        rightDrive2 = hardwareMap.get(DcMotor.class, "rightDrive2");

        leftDrive1.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.FORWARD);
        leftDrive2.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);

        leftDrive1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftDrive1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftDrive1.getCurrentPosition();
        leftDrive2.getCurrentPosition();
        rightDrive1.getCurrentPosition();
        rightDrive2.getCurrentPosition();

        waitForStart();

        encoderDrive(DRIVE_SPEED,  48,  48, 5.0);
        encoderDrive(TURN_SPEED,   12, -12, 4.0);
        encoderDrive(DRIVE_SPEED, -24, -24, 4.0);

    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) {

        int newLeftTarget;
        int newRightTarget;

        if (opModeIsActive()) {

            newLeftTarget = leftDrive1.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = rightDrive2.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            leftDrive1.setTargetPosition(newLeftTarget);
            rightDrive1.setTargetPosition(newRightTarget);
            leftDrive2.setTargetPosition(newLeftTarget);
            rightDrive2.setTargetPosition(newRightTarget);

            leftDrive1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightDrive1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftDrive2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightDrive2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            leftDrive1.setPower(Math.abs(speed));
            rightDrive1.setPower(Math.abs(speed));
            leftDrive2.setPower(Math.abs(speed));
            rightDrive2.setPower(Math.abs(speed));

        }
    }
}
