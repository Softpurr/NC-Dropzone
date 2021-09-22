import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  @ViewChild('content') content: any;
  @Input() titre: any;

  constructor(private modalService: NgbModal) { }
  
  open() {
    this.modalService.open(this.content, { ariaLabelledBy: 'modal-basic-title' })
  }
  
  ngOnInit(): void {
  }



}
