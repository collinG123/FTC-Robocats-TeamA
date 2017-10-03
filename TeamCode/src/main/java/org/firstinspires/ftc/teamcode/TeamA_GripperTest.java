/* Made by Collin G., Shan B., Michael K.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp GripperTest", group="Linear Opmode")
public class TeamA_GripperTest extends LinearOpMode {

    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor liftMotor = null;
    public Servo gripServo1 = null;             //left servo
    public Servo gripServo2 = null;             //right servo
    public double servoDegrees;
    public double servoEquation = (1/255 * servoDegrees);
    public boolean buttonAPressed = false;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        liftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            while (gamepad1.x) {
                liftMotor.setPower(0.5);
            }
            while (gamepad1.y) {
                liftMotor.setPower(-0.5);
            }
            if (gamepad1.a) {
                buttonAPressed = true;
            }

            if (buttonAPressed == true) {
                servoDegrees = 160;
                gripServo1.setPosition(servoEquation);

                servoDegrees = 95;
                gripServo2.setPosition(servoEquation);
            }
            while (gamepad1.b) {

            }
        }
    }
}
