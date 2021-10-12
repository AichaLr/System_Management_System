import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardFournisseurComponent } from './board-fournisseur.component';

describe('BoardFournisseurComponent', () => {
  let component: BoardFournisseurComponent;
  let fixture: ComponentFixture<BoardFournisseurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoardFournisseurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardFournisseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
