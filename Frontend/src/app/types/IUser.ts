export interface Institute {
    instituteName: string;
}

export interface User {
    userId: string;
    userPassword: string;
    userInstitute: Institute;
}

