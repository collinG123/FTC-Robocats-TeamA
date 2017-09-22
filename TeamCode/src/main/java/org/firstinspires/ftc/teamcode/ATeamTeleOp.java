/*
Made by Shan B., Collin G., Michael K.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp Alpha Mk.1", group="TeleOp")
public abstract class ATeamTeleOp extends LinearOpMode {
    
    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor leftDrive1 = null;
    public DcMotor leftDrive2 = null;
    public DcMotor rightDrive1 = null;
    public DcMotor rightDrive2 = null;

    @Override
    public void runOpMode() {
        telemetry.addLine("Initializing");
        telemetry.update();
        
        leftDrive1  = hardwareMap.get(DcMotor.class, "leftDrive1");
        rightDrive1 = hardwareMap.get(DcMotor.class, "rightDrive1");
        leftDrive2  = hardwareMap.get(DcMotor.class, "leftDrive2");
        rightDrive2 = hardwareMap.get(DcMotor.class, "rightDrive2");
        
        leftDrive1.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        leftDrive2.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addLine("Initialization Complete");
        telemetry.update();

        double leftDrivePower = .5;
        double rightDrivePower = .5;

        leftDrivePower  = -gamepad1.left_stick_y;
        rightDrivePower = -gamepad1.right_stick_y;

        leftDrive1.setPower(leftDrivePower);
        rightDrive1.setPower(rightDrivePower);

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftDrivePower, rightDrivePower);
    }
}