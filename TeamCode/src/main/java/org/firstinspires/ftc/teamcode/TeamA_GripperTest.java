/* Made by Collin G., Shan B., Michael K.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp GripperTest", group="Linear Opmode")
public class TeamA_GripperTest extends LinearOpMode {

    public ElapsedTime runtime = new ElapsedTime();
    //public DcMotor liftMotor = null;            //lift motor
    public Servo gripServo1 = null;             //left servo
    public Servo gripServo2 = null;             //right servo
    public double servoDegrees;
    public double servoEquation = (1/255 * servoDegrees);

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        gripServo1 = hardwareMap.get(Servo.class, "gripServo1");
        gripServo2 = hardwareMap.get(Servo.class, "gripServo2");
       //liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");

        //liftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            /*while (gamepad1.x) {
                liftMotor.setPower(0.5);
            }
            while (gamepad1.y) {
                liftMotor.setPower(-0.5);
            }*/
            if (gamepad1.a) { //opens gripper
                servoDegrees = 160;
                gripServo1.setPosition(servoEquation);

                servoDegrees = 95;
                gripServo2.setPosition(servoEquation);
            }
            if (gamepad1.b) { //closes gripper
                servoDegrees = 180;
                gripServo1.setPosition(servoEquation);

                servoDegrees = 0;
                gripServo2.setPosition(servoEquation);
            }
        }
    }
}
