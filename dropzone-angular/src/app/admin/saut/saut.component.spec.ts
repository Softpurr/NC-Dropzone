import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SautComponent } from './saut.component';

describe('SautComponent', () => {
  let component: SautComponent;
  let fixture: ComponentFixture<SautComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SautComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SautComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
