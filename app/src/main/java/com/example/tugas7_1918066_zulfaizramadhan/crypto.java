package com.example.tugas7_1918066_zulfaizramadhan;

    public class crypto {
        private String _id, _jenis, _pengertian;
        public crypto (String id, String jenis, String pengertian) {
            this._id = id;
            this._jenis = jenis;
            this._pengertian = pengertian;
        }
        public crypto() {
        }
        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
        }
        public String get_jenis() {
            return _jenis;
        }
        public void set_jenis(String _jenis) {
            this._jenis = _jenis;
        }
        public String get_pengertian() {
            return _pengertian;
        }
        public void set_pengertian(String _pengertian) {
            this._pengertian = _pengertian;
        }
    }

