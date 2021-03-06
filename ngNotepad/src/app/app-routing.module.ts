import { NotepadComponent } from './components/notepad/notepad.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AdminComponent } from './components/admin/admin.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { NotesComponent } from './components/notes/notes.component';
import { NgbCollapseModule } from '@ng-bootstrap/ng-bootstrap';
import { ProfileUpdateComponent } from './components/profile-update/profile-update.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'notes', component: NotesComponent },
  { path: 'notepad', component: NotepadComponent },
  { path: 'users', component: ProfileComponent },
  { path: 'profileUpdate', component: ProfileUpdateComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'navbar', component: NavBarComponent },
  { path: 'admin', component: AdminComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes, { useHash: true }), NgbCollapseModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
