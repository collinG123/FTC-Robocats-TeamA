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

@TeleOp(name="TeleOp Alpha 1.0", group="TeleOp")
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

        waitForStart();
        telemetry.clearAll();
        runtime.reset();

        while (opModeIsActive()) {

            rightDrive1.setPower(-gamepad1.right_stick_y);
            rightDrive2.setPower(-gamepad1.right_stick_y);
            leftDrive1.setPower(-gamepad1.left_stick_y);
            leftDrive2.setPower(-gamepad1.left_stick_y);

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
    }
}