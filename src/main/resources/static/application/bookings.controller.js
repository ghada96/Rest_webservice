(function () {
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http']; //access to restcontroller we need a dependancy to http

    function BookingsController($http) {
        var vm = this;
        vm.bookings=[];
        vm.getAll=getAll;
        vm.getAffordable=getAffordable;
        vm.deletebooking=deletebooking;

        init();
        function init() {
            getAll();

        }

        function getAll() {
            var url="/bookings/all";
            var bookingsdata=$http.get(url);
            bookingsdata.then(function (response) {
                vm.bookings=response.data;
            });

        }
        function getAffordable() {
            var url="/bookings/affordable/"+200.3;
            var bookingsdata=$http.get(url);
            bookingsdata.then(function (response) {
                vm.bookings=response.data;
            });


        }
        function deletebooking(id) {
            var url="/bookings/delete/"+id;
            var bookingsdata=$http.post(url);
            bookingsdata.then(function (response) {
                vm.bookings=response.data;
            });

        }
    }
})();