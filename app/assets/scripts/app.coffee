riot.route.base '/'
riot.route.stop()
riot.route.start true

riot.route '/', ->
  riot.mount 'header, footer', { sub: 'dashboard' }
  riot.mount '#content', 'dashboard'

riot.route '/*', (sub) ->
  riot.mount 'header, footer', { sub: sub }
  switch sub
    when 'dashboard'
      riot.mount '#content', 'dashboard'
    when 'contact'
      riot.mount '#content', 'contact'
    when 'features'
      riot.mount '#content', 'features'

riot.route '/auth/*', (sub) ->
  switch sub
    when 'sign-in'
      riot.mount '#content', 'sign-in'
      # riot.mount '#register', 'register'
    when 'sign-up'
      riot.mount '#content', 'sign-up'
