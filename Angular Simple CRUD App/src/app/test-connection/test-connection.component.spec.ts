import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestConnectionComponent } from './test-connection.component';

describe('TestConnectionComponent', () => {
  let component: TestConnectionComponent;
  let fixture: ComponentFixture<TestConnectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestConnectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestConnectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
