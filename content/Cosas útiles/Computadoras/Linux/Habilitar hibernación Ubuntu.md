`/etc/polkit-1/rules.d/10-enable-hibernate.rules`
```js
polkit.addRule(function(action, subject) {
    if (action.id == "org.freedesktop.login1.hibernate" && subject.isInGroup("sudo")) {
        return polkit.Result.YES;
    }
});
```