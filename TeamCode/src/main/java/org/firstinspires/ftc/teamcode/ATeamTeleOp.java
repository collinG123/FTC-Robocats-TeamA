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

@TeleOp(name="TeleOp Alpha 1.0", group="Linear Opmode")
public class ATeamTeleOp extends LinearOpMode {
    
    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor motorFrontLeft = null;
    public DcMotor motorBackLeft = null;
    public DcMotor motorFrontRight = null;
    public DcMotor motorBackRight = null;

    @Override
    public void runOpMode() { // this is still not working
        telemetry.addLine("Initializing");
        telemetry.update();

        motorFrontLeft = hardwareMap.get(DcMotor.class, "leftDrive1");
        motorFrontRight = hardwareMap.get(DcMotor.class, "rightDrive1");
        motorBackLeft = hardwareMap.get(DcMotor.class, "leftDrive2");
        motorBackRight = hardwareMap.get(DcMotor.class, "rightDrive2");

        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addLine("Initialization Complete");
        telemetry.update();

        waitForStart();
        telemetry.clearAll();
        runtime.reset();

        telemetry.addLine("Started");
        telemetry.update();

        while (opModeIsActive()) {

            motorFrontRight.setPower(-gamepad1.right_stick_y * 1.1);
            motorBackRight.setPower(-gamepad1.right_stick_y * 1.1);
            motorFrontLeft.setPower(-gamepad1.left_stick_y * 1.1);
            motorBackLeft.setPower(-gamepad1.left_stick_y* 1.1);

            /*
            Close grippers onto glyph.
            Lift up glyph.
            Place glyph on top of another glyph.
            Open and lower gripper.
            Close and grip both glyphs.
            Lift both glyphs.
            Drive to CryptoBox.
            Open gripper and drop off glyphs into CryptoBox.
            */

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", gamepad1.left_stick_y, gamepad1.right_stick_y);
            telemetry.update();
        }
        idle();
        requestOpModeStop();
    }
}