import { Component, OnInit } from '@angular/core';
import {Hardware} from "../hardware";
import {HardwareService} from "../hardware.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../security/authentication.service";

@Component({
  selector: 'app-hardwares',
  templateUrl: './hardwares.component.html',
  styleUrls: ['./hardwares.component.css']
})
export class HardwaresComponent implements OnInit {

  hardwares?: Hardware[];
  isUserAdmin: boolean;

  isUserCreator: boolean;

  constructor(
    private hardwareService: HardwareService,
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    this.isUserAdmin = this.authenticationService.isUserAdmin();
    this.isUserCreator = this.authenticationService.isUserCreator();
  }

  ngOnInit(): void {
    this.getHardwares();
  }

  getHardwares(): void {
    this.hardwareService.getHardwares()
      .subscribe(hardwares => this.hardwares = hardwares);
  }

  add(code: string, name: string, type: string, stock: number, price: number): void {
    code = code.trim();
    name = name.trim();
    type = type.trim();
    if (!code || !name || !type) {
      return;
    }

    this.hardwareService.addHardware({code, name, type, stock, price} as Hardware)
      .subscribe(
        hardware => {
          this.hardwares?.push(hardware);
        }
      );
  }

  delete(hardware: Hardware): void {
    this.hardwareService.deleteHardware(hardware).subscribe(
      () => this.hardwares = this.hardwares?.filter(h => h !== hardware)
    );
  }

  addStock(hardware: Hardware): void {
    
    hardware.stock += 1;
    console.log(hardware);
    this.hardwareService.updateHardware(hardware)
      .subscribe(
        hardware => {
          console.log(hardware);
        }
      )
  }

  reduceStock(hardware: Hardware): void {
    if(hardware.stock <= 0) return;
    hardware.stock -= 1;
    this.hardwareService.updateHardware(hardware)
      .subscribe(
        hardware => {
          console.log(hardware);
        }
      )
  }

  newHardware() {
    this.router.navigate(['/new-hardware']).then();
  }

}
