import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCdsComponent } from './add-cds.component';

describe('AddCdsComponent', () => {
  let component: AddCdsComponent;
  let fixture: ComponentFixture<AddCdsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCdsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
