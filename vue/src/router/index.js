import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Adopt from '../views/Adopt.vue'
import UserHomePage from '../views/UserHomepage.vue'
import Directory from '../views/Directory.vue'
import Volunteer from '../views/Volunteer.vue'
import AddUpdatePet from '../views/AddUpdatePet.vue'

// import PetDetails from '../views/PetDetails.vue'
import Applicants from '../views/Applicants.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  props: ['id'],
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/adopt",
      name: "adopt",
      component: Adopt,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/updatepets',
      name: 'updatepets',
      component: UserHomePage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/directory',
      name: 'directory',
      component: Directory,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/volunteer',
      name: 'volunteer',
      component: Volunteer,
      meta: {
        requiresAuth: false
      }
    },
    // {
    //   path: '/adopt/:id',
    //   name: 'adopt-pet',
    //   component: PetDetails,
    //   props: { PetDetails: true },
    //   meta: {
    //     requiresAuth: false
    //   }
    // },
    {
      path: '/pets/new',
      name: 'new-pet',
      component: AddUpdatePet,
      meta: {
        requiresAuth: true
      }




    },
    {
      path: '/applicants',
      name: 'applicants',
      component: Applicants,
      meta: {
        requiresAuth: false
      },
    },
  ]
})



router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
