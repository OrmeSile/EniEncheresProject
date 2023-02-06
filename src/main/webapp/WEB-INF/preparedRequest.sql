CREATE PROCEDURE cleanup_user
@userId int
AS
BEGIN
    BEGIN TRAN
        BEGIN TRY
            DELETE e FROM encheres e JOIN articles_vendus a ON e.no_article = a.no_article WHERE a.no_utilisateur = @userId;
            DELETE FROM ARTICLES_VENDUS WHERE no_utilisateur = @userId;
            DELETE FROM UTILISATEURS WHERE no_utilisateur = @userId;
            COMMIT TRANSACTION
        END TRY
        BEGIN CATCH
            ROLLBACK TRANSACTION
        END CATCH
END