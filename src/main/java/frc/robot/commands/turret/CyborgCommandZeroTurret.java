/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SubsystemTurret;

public class CyborgCommandZeroTurret extends CommandBase {
  private SubsystemTurret turret;

  /**
   * Creates a new CyborgCommandZeroTurret.
   */
  public CyborgCommandZeroTurret(SubsystemTurret turret) {
    this.turret = turret;
    addRequirements(this.turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(!turret.getYawLeftLimit()) {
      turret.setYawPercentOutput(.33D);
    } else {
      turret.setYawPercentOutput(0);
      turret.setYawEncoderPosition(0);
    }

    if(!turret.getPitchUpperLimit()) {
      turret.setPitchPercentOutput(-.4);
    } else {
      turret.setPitchPercentOutput(0);
      turret.setPitchEncoderPosition(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turret.setYawPercentOutput(0);
    turret.setPitchPercentOutput(0);
    turret.setYawEncoderPosition(0);
    turret.setPitchEncoderPosition(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turret.getPitchUpperLimit() && turret.getYawLeftLimit();
  }
}
