<sign-up>
  <div class="text-center mb-4">
    <h1 class="h3 mb-3 font-weight-normal">Sign Up Page</h1>
  </div>

  <div class="form-label-group">
    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputEmail">Email address</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <label for="inputPassword">Password</label>
  </div>
  <!-- <div class="checkbox mb-3"></div> -->

  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted text-center">
    &copy; 2017-2018
  </p>
  <script>
  var self = this
    helper = window.Helpers.factory()

    this.on('mount', function() {
      helper.setTitle({ title: 'Sign up' })
    })
  </script>
</sign-up>
