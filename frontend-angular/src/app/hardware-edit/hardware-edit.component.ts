import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HardwareService } from '../hardware.service';
import {Location} from "@angular/common";
import { Hardware } from '../hardware';
import { Review } from '../review';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-hardware-edit',
  templateUrl: './hardware-edit.component.html',
  styleUrls: ['./hardware-edit.component.css']
})
export class HardwareEditComponent implements OnInit {

  @Input() hardware!: Hardware;
  reviews?: Review[];

  constructor(
    private route: ActivatedRoute,
    private hardwareService: HardwareService,
    private reviewService: ReviewService,
    private router: Router,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    this.getHardware();
    console.log(this.hardware);
  }

  getHardware(): void {
    const code = this.route.snapshot.paramMap.get('code');

    if (code !== null) {
      this.hardwareService.getHardware(code)
        .subscribe(hardware => {
          this.hardware = hardware;
          this.reviewService.getReviewsByHardwareCode(hardware.code).subscribe(
            reviews => this.reviews = reviews
          );
        });
    } else {
      console.error('code can not be null!');
    }
  }

  save(): void {
    if (this.hardware !== undefined) {
      this.hardwareService.updateHardware(this.hardware)
        .subscribe(() => this.goBack());
    } else {
      console.error('hardware can not be undefined!');
    }
  }

  goBack(): void {
    this.location.back();
  }

}
